package dev.datlag.kommons


data object NewCaledonia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NC")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NCL")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(540)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(687)
}