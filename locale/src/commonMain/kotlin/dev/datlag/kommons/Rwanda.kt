package dev.datlag.kommons


data object Rwanda : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("RW")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("RWA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(646)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(250)
}