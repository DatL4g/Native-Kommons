package dev.datlag.kommons


data object SaintVincentAndTheGrenadines : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("VC")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("VCT")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(670)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1784)
}