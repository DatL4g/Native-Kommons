package dev.datlag.kommons


data object Uganda : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("UG")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("UGA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(800)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(256)
}